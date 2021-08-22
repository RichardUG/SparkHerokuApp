function paraIEX() {
    return "facadeiex"
}
function paraAlpha() {
    return "facadealpha"
}
function informacionAPI() {
    window.alert("Elija la API la cual desea consultar.");
}
function informacionStock() {
    window.alert("Introduzca le nombre del stock que desea consultar con la API que elegira.");
}
function ChangeStockOriginal() {
    if(document.getElementById("IEXCloud").checked){
        document.getElementById("digite").value="aapl";
    }"
    if(document.getElementById("AlphaVantage").checked){
        document.getElementById("digite").value="fb";
    }
}
function abrir() {
    if(document.getElementById("IEXCloud").checked){
        miVentana = window.open( paraIEX()+"?st="+document.getElementById("digite").value, "ventana1", "height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300");
    }
    if(document.getElementById("AlphaVantage").checked){
        miVentana = window.open( paraAlpha()+"?st="+document.getElementById("digite").value, "ventana1", "height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300");
    }
    miVentana.moveTo(-100, -100);
}