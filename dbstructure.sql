
CREATE TABLE marcas (
	id_marca serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE modelos (
	id_modelo serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL,
	id_marca INTEGER NOT NULL,
	
	CONSTRAINT fk_modelos_id_marca FOREIGN KEY (id_marca)
      REFERENCES marcas (id_marca)
);

CREATE TABLE cambios (
	id_cambio serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);


CREATE TABLE carrocerias (
	id_carroceria serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);


CREATE TABLE combustiveis (
	id_combustivel serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE versoes (
	id_versao serial PRIMARY KEY NOT NULL,
	id_modelo INTEGER NOT NULL,
	nome VARCHAR(50) NOT NULL,
	
	CONSTRAINT fk_versoes_id_modelo FOREIGN KEY (id_modelo)
      REFERENCES modelos(id_modelo)
	  
);

CREATE TABLE opcionais (
	id_opcional serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);


CREATE TABLE usuarios (
	id_usuario serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE anuncios (
	id_anuncio serial PRIMARY KEY NOT NULL,
	preco numeric NOT NULL,
	data_anuncio DATE NOT NULL,
	horario_anuncio TIME NOT NULL,
	data_atualizacao DATE NULL,
	horario_atualizacao DATE NULL,
	observacao VARCHAR(250),
	id_modelo INTEGER NOT NULL,
	id_versao INTEGER NOT NULL,
	
	id_combustivel INTEGER NULL,
	id_cambio INTEGER NULL,
	id_carroceria INTEGER NULL,
	
	id_usuario INTEGER NOT NULL,
	
	CONSTRAINT fk_anuncios_id_modelo FOREIGN KEY (id_modelo)
      REFERENCES modelos(id_modelo),
	  
	CONSTRAINT fk_anuncios_id_versao FOREIGN KEY (id_versao)
      REFERENCES versoes(id_versao),
	  
	CONSTRAINT fk_anuncios_id_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuarios(id_usuario),
	  
	CONSTRAINT fk_anuncios_id_combustivel FOREIGN KEY (id_combustivel)
      REFERENCES combustiveis(id_combustivel),
	  
	CONSTRAINT fk_anuncios_id_cambio FOREIGN KEY (id_cambio)
      REFERENCES cambios(id_cambio),
	  
	CONSTRAINT fk_anuncios_id_carroceria FOREIGN KEY (id_carroceria)
      REFERENCES carrocerias(id_carroceria)

);

CREATE TABLE fotos (
	id_foto serial PRIMARY KEY NOT NULL,
	diretorio VARCHAR NOT NULL,
	id_anuncio INTEGER NULL,
	
	CONSTRAINT fk_fotos_id_anuncio FOREIGN KEY (id_anuncio)
      REFERENCES anuncios (id_anuncio)
);

CREATE TABLE anuncios_opcionais (
	id_anuncio_opcional serial PRIMARY KEY NOT NULL,
	id_opcional INTEGER NOT NULL,
	id_anuncio INTEGER NOT NULL,
	
	CONSTRAINT fk_anuncios_opcionais_id_opcional FOREIGN KEY (id_opcional)
      REFERENCES opcionais (id_opcional),
	  
	CONSTRAINT fk_anuncios_opcionais_id_anuncio FOREIGN KEY (id_anuncio)
      REFERENCES anuncios (id_anuncio)
);

