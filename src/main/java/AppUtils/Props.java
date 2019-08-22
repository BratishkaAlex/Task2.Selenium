package AppUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {

    public static Properties getProps() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File("src/main/resources/config.properties")));
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
        return properties;
    }

    public String getUrl(Properties props){
        String url = props.getProperty("url");
        return url;
    }
}
