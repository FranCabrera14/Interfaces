package ceu.dam.ad.mongo.repositories;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.mongo.model.Pedido;


@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> , CustomPedidoRepository{
	
	public Optional<Pedido> findByNumero(Integer numero);
	
	public List<Pedido> findByFechaBetween(LocalDate fechaUno, LocalDate fechaDos);
}
