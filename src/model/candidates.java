package model;
public class candidates{
    private String name ;
    private String candiId ;

    public candidates(String name , String id) {
        this.name = name; 
        this.candiId = id ;
    }
    public String getName(){
        return this.name ;
    }
    public String getId(){
        return this.candiId ;
    }
    public void setName(String name){
        this.name = name ;
    }
    public void setId(String id){
        this.candiId = id ;
    }
    

    
}