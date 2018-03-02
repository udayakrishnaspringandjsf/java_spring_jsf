package com.football.jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class EJB {
	
	private static final String EJB_CONTEXT;

    static {
        try {
            EJB_CONTEXT = new InitialContext().lookup("java:app/FootyApp") + "/";
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // Constructors -------------------------------------------------------------------------------

    private EJB() {
        // Utility class, so hide default constructor.
    }

    // Helpers ------------------------------------------------------------------------------------

    /**
     * Lookup the current instance of the given EJB class from the JNDI context. If the given class
     * implements a local or remote interface, you must assign the return type to that interface to
     * prevent ClassCastException. No-interface EJB lookups can just be assigned to own type. E.g.
     * <li><code>IfaceEJB ifaceEJB = EJB.lookup(ConcreteEJB.class);</code>
     * <li><code>NoIfaceEJB noIfaceEJB = EJB.lookup(NoIfaceEJB.class);</code>
     * @param <T> The EJB type.
     * @param ejbClass The EJB class.
     * @return The instance of the given EJB class from the JNDI context.
     * @throws IllegalArgumentException If the given EJB class cannot be found in the JNDI context.
     */
    @SuppressWarnings("unchecked") // Because of forced cast on (T).
    public static <T> T lookup(Class<T> ejbClass) {
        String jndiName = "java:app/" + ejbClass.getPackage().getName()+"."+ejbClass.getSimpleName();

        try {
            // Do not use ejbClass.cast(). It will fail on local/remote interfaces.
            return (T) new InitialContext().lookup(jndiName);
        } catch (NamingException e) {
            throw new IllegalArgumentException(
                String.format("Cannot find EJB class %s in JNDI %s", ejbClass, jndiName), e);
        }
    }

}

