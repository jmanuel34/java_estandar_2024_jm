package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.BancaDaoFactory;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

class CajeroServiceImpl implements CajeroService {
	
	ClientesDao clientesDao;
	CuentasDao cuentasDao;
	MovimientosDao movimientosDao;
	
	public CajeroServiceImpl() {
		clientesDao = BancaDaoFactory.getClientesDao();
		cuentasDao = BancaDaoFactory.getCuentasDao();
		movimientosDao = BancaDaoFactory.getMovimientosDao();				
	}
	

	@Override
	public Cuenta obtenerCuenta(int idCuenta) {
		return cuentasDao.findById(idCuenta);
	}
	
	//extrae dinero de la cuenta indicada. Si la cuenta no existe
		//o no hay saldo suficiente la operación no se hace y se devuelve null
	@Override
	public Cuenta extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta= cuentasDao.findById(idCuenta);
		if (cuenta.getSaldo()>cantidad && cuenta!=null) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			cuentasDao.updateSaldo(idCuenta, cuenta.getSaldo());
			movimientosDao.save(new Movimiento(0, idCuenta, LocalDateTime.now(), cantidad, "extraccion"));
			return cuenta;
		}
		return null;
	}
	
	//ingresa dinero en la cuenta indicada. Si la cuenta no existe
		//la operación no se hace y se devuelve null
	@Override
	public Cuenta ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta= cuentasDao.findById(idCuenta);
			cuentasDao.updateSaldo(idCuenta, cantidad);
			movimientosDao.save(new Movimiento(idCuenta, LocalDateTime.now(), cantidad, "ingreso"));
			return cuenta;
	}
	//transfiere dinero entre las cuentas indicadas. Si alguna cuenta no existe
		//o no hay saldo suficiente la operación no se hace y se devuelve false
	@Override
	public boolean transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		Cuenta cuentaOrigen= cuentasDao.findById(idCuentaOrigen);
		Cuenta cuentaDestino= cuentasDao.findById(idCuentaDestino);
		if (cuentaOrigen != null && cuentaDestino !=null) {
			LocalDateTime fecha = LocalDateTime.now();
			Movimiento movE = new Movimiento(idCuentaOrigen, fecha, cantidad, "extraccion");
			Movimiento movI = new Movimiento(idCuentaDestino, fecha, cantidad, "ingreso");
			movimientosDao.save(movI);
			movimientosDao.save(movE);
			cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-cantidad);
			cuentasDao.updateSaldo(idCuentaOrigen, cuentaOrigen.getSaldo()-cantidad);
			cuentasDao.updateSaldo(idCuentaDestino, cuentaDestino.getSaldo()+cantidad);
			return true;
		}
		return false;
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		List<Cliente> clientes = new ArrayList<>();
		return clientesDao.findAll(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		return movimientosDao.findByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		Cuenta cuenta = cuentasDao.findById(idCuenta);
		
		return cuenta!=null?cuenta.  getSaldo():0;
	}


	@Override
	public boolean save(Cliente cliente) {
		return clientesDao.save(cliente);
	}

}
