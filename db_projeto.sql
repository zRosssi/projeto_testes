-- Table: estado

-- DROP TABLE estado;

CREATE TABLE estado
(
  id serial NOT NULL,
  nome character varying(60) NOT NULL,
  uf character varying(2) NOT NULL,
  CONSTRAINT estado_pkey PRIMARY KEY (id),
  CONSTRAINT uk_qmtrk1hei9mxr5p5gr1eckdx0 UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE estado
  OWNER TO postgres;

-- Table: cidade

-- DROP TABLE cidade;

CREATE TABLE cidade
(
  id serial NOT NULL,
  nome character varying(60) NOT NULL,
  estado_id integer NOT NULL,
  CONSTRAINT cidade_pkey PRIMARY KEY (id),
  CONSTRAINT fksatretdvg03if89kwwmiagnyd FOREIGN KEY (estado_id)
      REFERENCES estado (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cidade
  OWNER TO postgres;

-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  id serial NOT NULL,
  endereco character varying(60) NOT NULL,
  telefone character varying(20),
  cpf character varying(14) NOT NULL,
  login character varying(20) NOT NULL,
  nome character varying(60) NOT NULL,
  senha character varying(40) NOT NULL,
  cidade_id integer NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT fk44rheunl1yevdmlj08i369a3x FOREIGN KEY (cidade_id)
      REFERENCES cidade (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;
