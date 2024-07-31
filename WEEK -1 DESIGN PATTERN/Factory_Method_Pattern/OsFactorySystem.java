public class OsFactorySystem {
    
    public  Os getInstance(String str){

        if(str.equals("android")){
            return new Android();
        }else if(str.equals("ios")){
            return new IOS();
        }else{
            return new Window();
        }


    }
}
