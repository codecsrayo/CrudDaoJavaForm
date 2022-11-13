
use DAO;
CREATE TABLE [DAO].dbo.ciudad
(
    idciudad int IDENTITY(0,1) NOT NULL,
    ciudad varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
    CONSTRAINT cidudad_PK PRIMARY KEY (idciudad)
);

CREATE TABLE [DAO].dbo.estadocivil
(
    idestadocivil int IDENTITY(0,1) NOT NULL,
    estadocivil varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
    CONSTRAINT estadocivil_PK PRIMARY KEY (idestadocivil)
);

CREATE TABLE [DAO].dbo.sexo
(
    idsexo int IDENTITY(0,1) NOT NULL,
    sexo varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
    CONSTRAINT sexo_PK PRIMARY KEY (idsexo)
);

CREATE TABLE [DAO].dbo.infofuncionario
(
    idfuncionario varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
    nombres varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
    apellidos varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
    celular varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
    idestadocivil int NOT NULL,
    idsexo int NOT NULL,
    fechanacimiento date NULL,
    direccion varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
    idciudad int NOT NULL,
    CONSTRAINT infofuncionario_PK PRIMARY KEY (idfuncionario),
    CONSTRAINT infofuncionarioxciudad_FK FOREIGN KEY (idciudad) REFERENCES [DAO].dbo.cidudad(idciudad) ON UPDATE CASCADE,
    CONSTRAINT infofuncionarioxestadocivil_FK FOREIGN KEY (idestadocivil) REFERENCES [DAO].dbo.estadocivil(idestadocivil) ON UPDATE CASCADE,
    CONSTRAINT infofuncionarioxsexo_FK FOREIGN KEY (idsexo) REFERENCES [DAO].dbo.sexo(idsexo) ON UPDATE CASCADE
);