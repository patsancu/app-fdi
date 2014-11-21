<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Creación de avisos</title>

</head>


<div class="container">
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal" role="form">

				<div class="panel panel-primary">
					<div class="panel-heading">Cree su aviso</div>
					<div class="panel-body">
						<fieldset>
							<!-- <legend>Título</legend> -->
							<div class="form-group">

								<label class="col-sm-3 control-label" for="card-holder-name">
									Título </label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="card-holder-name"
										id="card-holder-name" placeholder="Título del post">
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-sm-3 control-label" for="card-number">Card
									Number</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" Name="card-number"
										id="card-number" placeholder="Debit/Credit Card Number">
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-sm-3 control-label" for="fecha-publicacion">Fecha
									de publicacion</label>
								<div class="col-sm-9">
									<div class="row">
										<div class="col-xs-3">
											<select class="form-control col-sm-2"
												name="fecha-publicacion" id="fecha-publicacion">
												<option>Mes</option>
												<option value="01">Enero (01)</option>
												<option value="02">Febrero (02)</option>
												<option value="03">Marzo (03)</option>
												<option value="04">Abril (04)</option>
												<option value="05">Mayo (05)</option>
												<option value="06">Junio (06)</option>
												<option value="07">Julio (07)</option>
												<option value="08">Agosto (08)</option>
												<option value="09">Septiembre (09)</option>
												<option value="10">Octubre (10)</option>
												<option value="11">Noviembre (11)</option>
												<option value="12">Diciembre (12)</option>
											</select>
										</div>
										<div class="col-xs-3">
											<select class="form-control" name="expiry-year">
												<option value="14">2014</option>
												<option value="15">2015</option>
												<option value="16">2016</option>
												<option value="17">2017</option>
												<!-- <option value="18">2018</option>
												<option value="19">2019</option>
												<option value="20">2020</option>
												<option value="21">2021</option>
												<option value="22">2022</option>
												<option value="23">2023</option> -->
											</select>
										</div>
										<div class="col-xs-3">
											<div class="checkbox">
												<label> <input type="checkbox"> Fecha actual
												</label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-sm-3 control-label" for="cvv">Card CVV</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="cvv" id="cvv"
										placeholder="Security Code">
								</div>
							</div> -->
						</fieldset>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="contenidoPost">Post</label>
							<div class="col-sm-offset-3 col-sm-9">
								<textarea class="form-control" name="contenidoPost" placeholder="Escriba aquí el contenido de su post" rows="3"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="datosAviso">Adjuntar
								archivo</label>
							<div class="col-sm-offset-3 col-sm-9">
								<form:input id="datosAviso" path="productImage" type="file"
									class="form:input-large" />
								<input type="submit" id="btnAdd" class="btn btn-primary"
									value="Add" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="tipoDestino">Destino</label>
							<div class="btn-group col-sm-offset-3 col-sm-9" id="tipoDestino"
								role="group" aria-label="...">
								<button type="button" class="btn btn-default">URL</button>
								<button type="button" class="btn btn-default">Archivo</button>
								<button type="button" class="btn btn-default">Contenido
									post</button>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="tipoAviso">Tipo
								de aviso</label>
							<div class="btn-group col-sm-offset-3 col-sm-9" id="tipoAviso"
								role="group" aria-label="...">
								<button type="button" class="btn btn-default">Normal</button>
								<button type="button" class="btn btn-default">Importante</button>
							</div>
						</div>
						<div class="form-group ">
							<label class="col-sm-3 control-label" for="etiqueta">Etiqueta</label>
							<div class="col-sm-offset-3 col-sm-9">
								<input type="text" id="etiqueta" class="form-control"
									placeholder="Etiqueta">
							</div>
						</div>
					</div>

					<div class="panel-footer">
						<button type="button" class="btn btn-success">Publicar</button>
						<button type="button" class="btn btn-primary">Guardar
							borrador</button>
						<div class="pull-right">
							<button type="button" class="btn btn-danger">
								<i class="fa fa-trash-o"></i> Eliminar
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</html>