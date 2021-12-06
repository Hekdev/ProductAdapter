package com.example.myapptp2listeprod;

public class Products {
   public  String p_intitule;
   public  float p_prix;
   public int p_id_image;
    public Products(String p_intitule,float p_prix,int p_id_image){
        this.p_intitule=p_intitule;
        this.p_prix=p_prix;
        this.p_id_image=p_id_image;
    }
    public  String getIntitule()
    {

        return p_intitule;
    }
    public  float getPrix(){

        return p_prix;
    }
    public  int getIdImage(){

        return p_id_image;
    }
    @Override
    public String toString()
    {
        return p_intitule + "  -  Prix:" + Double.toString(p_prix) +" dh";
    }
    //Pour afficher le prix dans une TextView Il vaut mieux le convertir en un String
    public String getP_prixString() {
        return Float.toString(p_prix);}
}



