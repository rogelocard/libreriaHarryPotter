$(document).ready(function(){
    $("tr #btnDelete").click(function(){
        var idbook=$(this).parent().find("#idbook").val();
        eliminar(idbook);
    });
    
    function eliminar(idbook) {
        var url="Controlador?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idbook="+idbook,
            success: function (data, textStatus, jqXHR) {
                alert("Registro eliminado");
            }
        })
    }
    
    $("tr #Cantidad").click(function(){
        var idl=$(this).parent().find("#idlib").val();
        var cantidad=$(this).parent().find("#Cantidad").val();
        var url="Controlador?accion=ActualizarCantidad";
        $.ajax({
            type:'POST',
            url: url,
            data: "idl="+idl+"&Cantidad="+cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href="Controlador?accion=Carrito";
            }
        })
    })
})


