use VehicleServicesAndFuelManagement;
create table part(
	partId int,
	partName varchar(100),
	price real,
    qut int,
    model varchar(100),
    brand varchar(100),
    photo varchar(225),
	primary Key(partId)
);

create table customer(
	customerId int,
	customerName varchar(100),
	customerPhone varchar(100),
	customerEmail varchar(100),
	customerAddress varchar(100),
	primary Key(customerId)
);

drop table vehicle;

create table vehicle(
	vehicleId int NOT NULL AUTO_INCREMENT,
	EngineNumber varchar(100),
	VehicleNumber varchar(100),
	VehicleClass varchar(100),
	Brand varchar(100),
	Model varchar(100),
	YearOfManufacture varchar(100),
	DateOfRegistration varchar(100),
	fuelType varchar(100),
	customerId int ,
	primary Key(vehicleId),
	CONSTRAINT FK_Vehicle FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

create table jobOrder(
	jobOrderId int NOT NULL AUTO_INCREMENT,
	jobOrderDescription varchar(250),
	jobOrderStatus varchar(100),
	customerId int,
	primary key(jobOrderId),
	CONSTRAINT FK_JOBID FOREIGN KEY (customerId) REFERENCES customer(customerId)
);


create table specialService(
	specialServiceId int NOT NULL AUTO_INCREMENT,
	specialServiceName varchar(100),
	primary key(specialServiceId)
);

create table sepcialJObOrder(
	sJobOrderId int NOT NULL AUTO_INCREMENT,
	status  varchar(100),
	primary key(sJobOrderId)
);

create table specialServiceJobOrder(
	specialServiceId int,
	sJobOrderId int,
	primary key(specialServiceId,sJobOrderId),
	constraint fk_ssi Foreign key(specialServiceId) References specialService(specialServiceId),
	constraint fk_sJ Foreign key(sJobOrderId) References sepcialJObOrder(sJobOrderId)
);

select DISTINCT v.EngineNumber,v.VehicleClass,v.Brand,v.Model,v.YearOfManufacture,v.DateOfRegistration,v.fuelType from vehicle v,customer c where v.customerId=c.customerId && ( c.customerFName='Gnanod' || v.VehicleNumber='Gnanod');

Insert into vehicle values(0,'480967f','BAC3302','Class A','Honda','Civic','2018','2018-06-19','Petrol',1);
Insert into vehicle values(0,'757967f','BAE3602','Class A','Toyota','Prius','2017','2018-06-18','Petrol',1);
Insert into vehicle values(0,'545967f','BAE7677','Class A','Toyota','Aqua','2019','2018-07-19','Petrol',2);