package ceu.dam.examen.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.examen.model.Ceo;
import ceu.dam.examen.model.Empleado;
import ceu.dam.examen.model.Empresa;
import ceu.dam.examen.repositories.CeoRepository;
import ceu.dam.examen.repositories.EmpleadoRepository;
import ceu.dam.examen.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class ContratacionesServiceImpl implements ContratacionesService {

	@Autowired
	EmpleadoRepository repoEmpleado;
	@Autowired
	EmpresaRepository repoEmpresa;
	@Autowired
	CeoRepository repoCeo;

	@Override
	public Empleado consultarEmpleado(String dni) throws NoEncontradoException {
		try {
			Optional<Empleado> empleadoOpt = repoEmpleado.findByDni(dni);
			if (!empleadoOpt.isPresent()) {
				throw new NoEncontradoException("No se ha encontrado un empleado con ese dni");
			}

			return empleadoOpt.get();
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public Empresa consultarEmpresa(String codigo) throws NoEncontradoException {
		try {
			Optional<Empresa> empresaOpt = repoEmpresa.findByCodigo(codigo);
			if (!empresaOpt.isPresent()) {
				throw new NoEncontradoException("No se ha encontrado esa empresa con ese código");
			}
			return empresaOpt.get();
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void crearEmpresa(Empresa empresa) throws DuplicadosException {

		try {
			Optional<Empresa> empresaOpt = repoEmpresa.findByCodigo(empresa.getCodigo());
			Optional<Ceo> ceoOpt = repoCeo.findByEmail(empresa.getCeo().getEmail());
			if (empresaOpt.isPresent() || ceoOpt.isPresent()) {
				throw new DuplicadosException("Ya existe una empresa con ese código");
			}
			repoEmpresa.save(empresa);
		} catch (DataAccessException e) {
			System.out.println("Algo ha salido regulinchi" + e);
			e.printStackTrace();
		}

	}

	@Override
	public Empleado contratarEmpleado(String dni, String nombre, String codEmpresa)
			throws NoEncontradoException, DuplicadosException {
		try {
			Optional<Empleado> empleadoOpt = repoEmpleado.findByDni(dni);
			Optional<Empresa> empresaOpt = repoEmpresa.findByCodigo(codEmpresa);
			if (empleadoOpt.isPresent()) {
				throw new DuplicadosException("Ya existe un empleado con ese dni");
			} else if (!empresaOpt.isPresent()) {
				throw new NoEncontradoException("No existe una empresa con ese código");
			}
			Empleado emp = new Empleado();
			emp.setDni(dni);
			emp.setEmpresa(empresaOpt.get());
			emp.setFechaContrato(LocalDate.now());
			emp.setNombreCompleto(nombre);
			return repoEmpleado.save(emp);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public List<Empleado> consultarEmpleadosContratados(String codEmpresa, LocalDate fechaDesde, LocalDate fechaHasta)
			throws NoEncontradoException {
		try {
			Optional<Empresa> empresaOpt = repoEmpresa.findByCodigo(codEmpresa);
			if (!empresaOpt.isPresent()) {
				throw new NoEncontradoException("No hay una empresa con ese código");
			}
			List<Empleado> listEmpleado = repoEmpleado.findByFechaContratoBetween(fechaDesde, fechaHasta);
			List<Empleado> listaNueva = new ArrayList<Empleado>();
			for (Empleado empleado : listEmpleado) {
				if (empleado.getEmpresa().getCodigo().equals(codEmpresa)) {
					listaNueva.add(empleado);
				}
			}

			return listaNueva;
		} catch (DataAccessException e) {
			throw e;
		}
	}

}
