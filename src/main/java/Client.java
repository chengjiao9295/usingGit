import java.lang.reflect.*;

import java.util.Map;

import org.junit.Test;

/**
 *
 */
public class Client {
    private Map<String, Object> objectMap;

    /**
     * Method description
     *
     *
     * @throws Exception
     */
    @Test
    public void client() throws Exception {
        ObjectPool pool = ObjectPool.init("config.json");
        User       user = (User) pool.getObject("id1");

        System.out.println(user);

        Bean bean = (Bean) pool.getObject("id2");

        System.out.println(bean);

        ComplexBean complexBean = (ComplexBean) pool.getObject("id3");

        System.out.println(complexBean);

        User  user1   = new User();
        Field idFiled = User.class.getDeclaredField("id");

        setAccessible(idFiled);
        idFiled.setInt(user1, 46);

        Field nameFiled = User.class.getDeclaredField("name");

        setAccessible(nameFiled);
        nameFiled.set(user1, "feiqing");

        Field passwordField = User.class.getDeclaredField("password");

        setAccessible(passwordField);
        passwordField.set(user1, "ICy5YqxZB1uWSwcVLSNLcA==");
        System.out.println(user1);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Map<User, Bean> test() {
        return null;
    }

    /**
     * Method description
     *
     *
     * @param map
     * @param string
     */
    public void test(Map<String, User> map, String string) {}

    /**
     * 测试属性类型
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void testFieldType() throws NoSuchFieldException {
        Field field = Client.class.getDeclaredField("objectMap");
        Type  gType = field.getGenericType();

        // 打印type与generic type的区别
        System.out.println(field.getType());
        System.out.println(gType);
        System.out.println("**************");

        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type[]            types = pType.getActualTypeArguments();

            for (Type type : types) {
                System.out.println(type.toString());
            }
        }
    }

    /**
     * 测试参数类型
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testParamType() throws NoSuchMethodException {
        Method testMethod     = Client.class.getMethod("test", Map.class, String.class);
        Type[] parameterTypes = testMethod.getGenericParameterTypes();

        for (Type type : parameterTypes) {
            System.out.println("type -> " + type);

            if (type instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) type).getActualTypeArguments();

                for (Type actualType : actualTypes) {
                    System.out.println("\tactual type -> " + actualType);
                }
            }
        }
    }

    /**
     * 测试返回值类型
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testReturnType() throws NoSuchMethodException {
        Method testMethod = Client.class.getMethod("test");
        Type   returnType = testMethod.getGenericReturnType();

        System.out.println("return type -> " + returnType);

        if (returnType instanceof ParameterizedType) {
            Type[] actualTypes = ((ParameterizedType) returnType).getActualTypeArguments();

            for (Type actualType : actualTypes) {
                System.out.println("\tactual type -> " + actualType);
            }
        }
    }

    private void setAccessible(AccessibleObject object) {
        object.setAccessible(true);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
