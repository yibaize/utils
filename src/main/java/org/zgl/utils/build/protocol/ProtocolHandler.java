package org.zgl.utils.build.protocol;

import org.zgl.utils.CheckType;
import org.zgl.utils.StringUtils;
import org.zgl.utils.model.CodeModel;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ProtocolHandler {
    public static ProtocolPackage hancler(CodeModel model){
        Class c = model.getClazz();
        Constructor[] cs;
        /**
         * 构造函数也是对象
         * java.lang.Constructor封装了构造函数的信息
         *
         */
        cs = c.getConstructors();
        ProtocolPackage protocolModule = new ProtocolPackage();
        try {
            protocolModule.setClazzId(Integer.parseInt(model.getId()));
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> fields = new ArrayList<>();
        for (Constructor constructor : cs) {
            //获取构造函数的参数列表------>得到的是参数列表的类类型
            Class[] paramType = constructor.getParameterTypes();
            int i = 0;
            protocolModule.setClazzName(c.getName());
            for (Class<?> class1 : paramType) {
                i++;
                String type = CheckType.getArrType(class1.getName(),c.getName(),"");
                if(StringUtils.equals(type,"string"))
                    type = "String";
                fields.add(type);
            }
            protocolModule.setField(fields);
        }
        return protocolModule;
    }
}
