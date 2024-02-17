

program puntoCuatro;
const
  maxRub = 8;
type
  subRub = 1..maxRub;
  producto = record
    cod:integer;
    rubro:subRub;
    precio:real;
  end;
  lista =^nodo;
  listaProd = record
    prod:producto;
    sig:lista;
  end;
  vProd = array [subRub] of listaProd;

procedure leerProd (var p:producto);
  read(p.precio);
  if (p.precio<>0) then begin
    read(p.rubro);
    read(p.cod);
  end;
end;

{Punto a. Necesito hacer dos cosas:
* UNO: veo de que rubro es y lo mando a la lista de ese rubro
* DOS: insertar ordenado en la lista correspondiente}

procedure cargarVectorDeListas (var v:vProd);
var
  nuevo:listaProd;
begin
  leerProd (nuevo.prod);
  nuevo.sig := nil;
  if (v[prod.rubro] = nil) then
    v[prod.rubro]:=nuevo
  else
    {Aca llamo a un procedimiento para que me inserte ordenado el nuevo producto}
end;

procedure iniciarVecListas (var v:vProd);
var
  i:subRub;
begin
  for i := 1 to maxRub do
    new (v[i]);
end;
  
var
  v:vProd;
begin
  iniciarVecListas (v);
end.
