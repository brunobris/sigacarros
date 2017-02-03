
CREATE TABLE marcas (
	id_marca serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL,
	principal BOOLEAN NOT NULL DEFAULT 'false'
);


CREATE TABLE modelos (
	id_modelo serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL,
	id_marca INTEGER NOT NULL REFERENCES marcas(id_marca)
      
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
	id_modelo INTEGER NOT NULL REFERENCES modelos(id_modelo),
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE opcionais (
	id_opcional serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);


CREATE TABLE usuarios (
	id_usuario serial PRIMARY KEY NOT NULL,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE veiculos (
	id_veiculo serial PRIMARY KEY NOT NULL,
	id_modelo INTEGER NOT NULL REFERENCES modelos(id_modelo),
	id_versao INTEGER NOT NULL REFERENCES versoes(id_versao),
	
	id_combustivel INTEGER REFERENCES combustiveis(id_combustivel),
	id_cambio INTEGER REFERENCES cambios(id_cambio),
	id_carroceria INTEGER REFERENCES carrocerias(id_carroceria)
);

CREATE TABLE anuncios (
	id_anuncio serial PRIMARY KEY NOT NULL,
	data_anuncio DATE NOT NULL,
	horario_anuncio TIME NOT NULL,
	data_atualizacao DATE NULL,
	horario_atualizacao DATE NULL,
	preco numeric NOT NULL,
	observacao VARCHAR(250),
	id_veiculo INTEGER NOT NULL REFERENCES veiculos(id_veiculo),
	id_usuario INTEGER NOT NULL REFERENCES usuarios(id_usuario)
);

CREATE TABLE fotos (
	id_foto serial PRIMARY KEY NOT NULL,
	diretorio VARCHAR NOT NULL,
	id_anuncio INTEGER NOT NULL REFERENCES anuncios(id_anuncio)
);

CREATE TABLE veiculos_opcionais (
	id_veiculo INTEGER NOT NULL REFERENCES veiculos(id_veiculo),
	id_opcional INTEGER NOT NULL REFERENCES opcionais(id_opcional)
);

