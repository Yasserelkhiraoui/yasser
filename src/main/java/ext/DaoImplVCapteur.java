package ext;

import org.springframework.stereotype.Component;

@Component("VC")

public class DaoImplVCapteur implements IDao{
    @Override
    public double getData(){
        System.out.println("version capteur");
        double data=77;
        return data;
    }
}
