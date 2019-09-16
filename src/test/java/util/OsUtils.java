package util;

public final class OsUtils
{
    private static String OS = null;
    public static String getOperatingSystemName()
    {
        if(OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }
}
