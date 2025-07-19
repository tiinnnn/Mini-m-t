package mini.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mini.entity.KhachHang;


public class XQuery {

    
    public static <B> B getSingleBean(Class<B> beanClass, String sql, Object... values) {
        List<B> list = XQuery.getBeanList(beanClass, sql, values);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    
    public static <B> List<B> getBeanList(Class<B> beanClass, String sql, Object... values) {
        List<B> list = new ArrayList<>();
        try {
            ResultSet resultSet = XJdbc.executeQuery(sql, values);
            while (resultSet.next()) {
                list.add(XQuery.readBean(resultSet, beanClass));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    
    private static <B> B readBean(ResultSet resultSet, Class<B> beanClass) throws Exception {
    B bean = beanClass.getDeclaredConstructor().newInstance();
    Method[] methods = beanClass.getDeclaredMethods();

    for (Method method : methods) {
        String name = method.getName();
        if (name.startsWith("set") && method.getParameterCount() == 1) {
            String fieldName = name.substring(3);
            String columnName = Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);

            Class<?> paramType = method.getParameterTypes()[0];

            try {
                Object value;

                // Ép kiểu tuỳ theo kiểu dữ liệu của field
                if (paramType == int.class || paramType == Integer.class) {
                    value = resultSet.getInt(columnName);
                } else if (paramType == float.class || paramType == Float.class) {
                    value = resultSet.getFloat(columnName);
                } else if (paramType == double.class || paramType == Double.class) {
                    value = resultSet.getDouble(columnName);
                } else if (paramType == boolean.class || paramType == Boolean.class) {
                    value = resultSet.getBoolean(columnName);
                } else if (paramType == String.class) {
                    value = resultSet.getString(columnName);
                } else {
                    value = resultSet.getObject(columnName);
                }

                method.invoke(bean, value);

            } catch (SQLException | IllegalAccessException | InvocationTargetException e) {
                System.out.printf("+ Column '%s' not found or error mapping to %s\n", columnName, paramType.getSimpleName());
            }
        }
    }

    return bean;
}


    
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    private static void demo1() {
        String sql = "SELECT * FROM KhachHang WHERE maKH=? AND tenKH=?";
        KhachHang user = XQuery.getSingleBean(KhachHang.class, sql, "KH06", "Anh");
    }

    private static void demo2() {
        String sql = "SELECT * FROM KhachHang WHERE tenKH LIKE ?";
        List<KhachHang> list = XQuery.getBeanList(KhachHang.class, sql, "%px %");
    }

}