use [Autovit]
go

create table MasiniCautate(
	primary key (idMasiniCautate),
	idMasiniCautate int identity (1,1),
	Marca varchar (100),
	Model varchar (100),
	Pretmin varchar (10),
	Pretmax varchar (10),
	Anmin varchar (4),
	Anmax varchar (4),
	Combustibil varchar (30)
)

create table MasiniGasite(
	primary key (idMasiniGasite),
	idMasiniGasite int identity (1,1),
	Marca varchar (100),
	Descriere varchar (500),
	Motorizare varchar (50),
	Km varchar (30),
	An varchar (4),
	Locatie varchar (30),
	Pret varchar (20),
	Link varchar (500)
	)

select * from MasiniCautate

insert into MasiniCautate values ('Mazda','3','10000','15000','2015','2017','benzina')
insert into MasiniCautate values ('Kia','Ceed','10000','15000','2015','2017','benzina')
insert into MasiniCautate values ('Honda','Civic','10000','15000','2015','2017','benzina')

select * from MasiniGasite