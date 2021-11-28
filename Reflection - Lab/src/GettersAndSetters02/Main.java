package GettersAndSetters02;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> !method.getName().equals("toString"))
                .sorted(new MethodsComparator())
                .forEach(Main::printMethodInfo);
    }


    private static class MethodsComparator implements Comparator<Method> {
        @Override
        public int compare(Method o1, Method o2) {
            boolean firstIsGetter = o1.getName().startsWith("get");
            boolean secondIsGetter = o2.getName().startsWith("get");
            if (firstIsGetter && secondIsGetter) {
                return o1.getName().compareTo(o2.getName());
            }

            boolean firstIsSetter = o1.getName().startsWith("set");
            boolean secondIsSetter = o2.getName().startsWith("set");
            if (firstIsSetter && secondIsSetter) {
                return o1.getName().compareTo(o2.getName());
            }
            return Boolean.compare(secondIsGetter, firstIsGetter);
        }
    }

    private static void printMethodInfo(Method method) {
        System.out.println(method.getName().startsWith("get")
                ? String.format("%s will return class %s", method.getName(),
                method.getReturnType().getName())
                : String.format("%s and will set field of class %s", method.getName(),
                method.getParameterTypes()[0].getName()));
    }
}
