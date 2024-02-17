{2. Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la
información de los autos en venta. Implementar un programa que:
a) Lea la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo) y los almacene en dos estructuras de datos:}
program puntoDos;
const
  anioIni=2010;
  anioFin=2018;
type
  subanio=anioIni..anioFin;
  auto=record
    patente:integer;
    anio:subanio;
    marca:string;
    modelo:integer;
  end;
  
  arbolUno=^nodoUno;
  nodoUno=record
    dato:auto;
    hI:arbolUno;
    hD:arbolUno;
  end;
  
  regXMarca=record
    patente:integer;
    anio:subanio;
    modelo:integer;
  end;
  listaAuto=^nodoAuto;
  nodoAuto=record
    dato:regXMarca;
    sig:listaAuto;
  end;
  regAuto=record
    marca:string;
    autos:listaAuto;
  end;
  arbolDos=^nodoDos;
  nodoDos=record
    dato:regAuto;
    hI:arbolDos;
    hD:arbolDos;
  end;
 
  autoAnio=record
    patente:integer;
    marca:string;
    modelo:integer;
  end;  
  listaAnio=^nodoAnio;
  nodoAnio=record
    dato:autoAnio;
    sig:listaAnio;
  end;
  vectorAnio=array[subanio] of listaAnio;
  
{i. Una estructura eficiente para la búsqueda por patente.}
procedure leerAuto(var a:auto); {este modulo me sirve para el punto i y el ii}
begin
  read(a.patente);
  if (a.patente<>0)then begin
    read(a.anio);
    read(a.marca);
    read(a.modelo);
  end;
end;

procedure cargaArbolUno(var a:arbolUno);

procedure agregar(var a:arbolUno;aut:auto);
begin
  if(a=nil)then begin
    new(a);
    a^.dato:=aut;
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (aut.patente<a^.dato.patente)then
    agregar(a^.hI,aut)
  else
    agregar(a^.hD,aut);
end;

var
  aux:auto;
begin
  leerAuto(aux);
  if(aux.patente<>0)then begin
    agregar(a,aux);
    cargaArbolUno(a);
  end;
end;
{ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.}
procedure cargaArbolDos(var a:arbolDos);

procedure agregarLista(var l:listaAuto;a:auto);
var
  nuevo:listaAuto;
begin
  new(nuevo);
  nuevo^.dato.patente:=a.patente;
  nuevo^.dato.anio:=a.anio;
  nuevo^.dato.modelo:=a.modelo;
  nuevo^.sig:=nil;
  if(l=nil)then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

procedure agregarArbolDos(var a:arbolDos;aut:auto);
begin
  if(a=nil)then begin
    new(a);
    a^.dato.marca:=aut.marca;
    a^.dato.autos:=nil;
    agregarLista(a^.dato.autos,aut);
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (aut.marca=a^.dato.marca)then
    agregarLista(a^.dato.autos,aut)
  else if (aut.marca<a^.dato.marca)then
    agregarArbolDos(a^.hI,aut)
  else
    agregarArbolDos(a^.hD,aut);
end;

var
  aux:auto;
begin
  leerAuto(aux);
  if(aux.patente<>0)then begin
    agregarArbolDos(a,aux);
    cargaArbolDos(a);
  end;
end;

{b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.}
function contarMarcaUno(a:arbolUno;marca:string):integer;
begin
  if(a=nil)then
    contarMarcaUno:=0
  else if (a^.dato.marca=marca)then
    contarMarcaUno:=1+contarMarcaUno(a^.hI,marca)+contarMarcaUno(a^.hD,marca)
  else
    contarMarcaUno:=contarMarcaUno(a^.hI,marca)+contarMarcaUno(a^.hD,marca);
end;

{c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.}
function contarMarcaDos(a:arbolDos;marca:string):integer;

function contarLista(a:listaAuto):integer;
begin
  if(a=nil)then
    contarLista:=0
  else
    contarLista:=1+contarLista(a^.sig);
end;

begin
  if(a=nil)then
    contarMarcaDos:=0
  else if (a^.dato.marca<marca)then
    contarMarcaDos:=contarMarcaDos(a^.hD,marca)
  else if (a^.dato.marca>marca)then
    contarMarcaDos:=contarMarcaDos(a^.hI,marca)
  else
    contarMarcaDos:=contarLista(a^.dato.autos);
end;

{d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.}
{UN VECTOR DE LISTAS}
procedure vectorDeAnios(a:arbolUno;var v:vectorAnio);

procedure cargaVectorLista(a:auto;var l:listaAnio);
var
  nuevo:listaAnio;
begin
  new(nuevo);
  nuevo^.dato.patente:=a.patente;
  nuevo^.dato.marca:=a.marca;
  nuevo^.dato.modelo:=a.modelo;
  nuevo^.sig:=nil;
  if(l=nil)then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

begin
  if(a<>nil)then begin
    vectorDeAnios(a^.hI,v);
    cargaVectorLista(a^.dato,v[a^.dato.anio]);
    vectorDeAnios(a^.hD,v);
  end;
end;

procedure inicioVector(var v:vectorAnio);
var
  i:integer;
begin
  for i:= anioIni to anioFin do
    v[i]:=nil;
end;

{e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.}
function buscarModeloPatente(a:arbolUno;pat:integer):integer;
begin
  if (a=nil)then
    buscarModeloPatente:=0
  else if(a^.dato.patente=pat)then
    buscarModeloPatente:=a^.dato.modelo
  else if (a^.dato.patente<pat)then
    buscarModeloPatente:=buscarModeloPatente(a^.hD,pat)
  else
    buscarModeloPatente:=buscarModeloPatente(a^.hI,pat);
end;

{f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente.}
function buscarModeloPatenteB(a:arbolDos;pat:integer):integer;

function buscarPatenteEnLista(l:listaAuto;pat:integer):integer;
begin
  if(l=nil)then
    buscarPatenteEnLista:=0
  else if (l^.dato.patente=pat)then
    buscarPatenteEnLista:=l^.dato.modelo
  else
    buscarPatenteEnLista:=buscarPatenteEnLista(l^.sig,pat);
end;

var
  modelo:integer;
begin
  if (a=nil) then
    buscarModeloPatenteB:=0
  else begin
    modelo:=buscarPatenteEnLista(a^.dato.autos,pat);
    if (modelo<>0) then
      buscarModeloPatenteB:=modelo
    else begin
      buscarModeloPatenteB:=buscarModeloPatenteB(a^.hI,pat);
      buscarModeloPatenteB:=buscarModeloPatenteB(a^.hD,pat);
    end;
  end;
end;

var
  aUno:arbolUno;
  aDos:arbolDos;
  marca:string;
  v:vectorAnio;
  patente:integer;
begin
  aUno:=nil;
  cargaArbolUno(aUno);
  cargaArbolDos(aDos);
  read(marca);
  writeln('Cantidad de autos de la marca ingresada: ', contarMarcaUno(aUno,marca));
  inicioVector(v);
  vectorDeAnios(aUno,v);
  read(patente);
  if(aUno<>nil)then
    writeln('Modelo de esta patente: ',buscarModeloPatente(aUno,patente));
    writeln('Modelo de esta patente: ',buscarModeloPatenteB(aDos,patente));
end.
