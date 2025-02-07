package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class Pedido {
	@Id
	private String id;
	@NotNull
	private Cliente cliente;
	@NotNull
	private LocalDate fecha;
	@NotNull
	private Integer numero;
	@NotNull
	@Size(min = 1)
	private List<PedidoDetalle> detalles;
	
}
