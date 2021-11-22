package com.myapplication.Data;

public class Structure {

    interface ColumnCar{
        String idC = "id_car";
        String nameC = "name_car";
        String valueC = "value_car";
        String placaC = "placa_car";
        String modelC = "model_car";
        String colorC = "color_car";
        String typeC = "type_car";
        String urlC = "url_car";
        String documentC = "document_owner";
    }

    interface ColumnPerson{
        String documentP = "document_person";
        String nameP = "name_person";
        String edadP = "edad_person";
        String emailP = "email_person";
        String telefonoP = "telephone_person";
    }

    interface ColumnSeller {
        String documentS = "document_seller";
        String nameS = "name_seller";
        String typeS = "type_seller";
        String areaS = "area_seller";
        String sucursalS = "sucursal_seller";
        String telephoneS = "telephone_seller";
        String emailS = "email_seller";
    }
}
