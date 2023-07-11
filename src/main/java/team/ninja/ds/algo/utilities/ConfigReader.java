package team.ninja.ds.algo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static team.ninja.ds.algo.constants.DsAlgoConstant.CONFIG_FILE_PATH;

public class ConfigReader {

	private static Properties prop;

	public Properties init_prop() throws IOException {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getUrl1() {

		String getUrl = prop.getProperty("url");
		if (getUrl != null) {
			return getUrl;
		} else {
			System.out.println("url not mentioned in config properties");
		}
		return getUrl;
	}

	public static String homePage() {
		String homepageurl = prop.getProperty("homePageUrl");
		if (homepageurl != null)
			return homepageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}

	public static String registerPage() {
		String registerpageurl = prop.getProperty("registerPageUrl");
		if (registerpageurl != null)
			return registerpageurl;
		else
			throw new RuntimeException("RegisterPageurl not specified in the Config.properties file");
	}

	public static String excelPath() {
		String ExcelPath = prop.getProperty("ExceldataPath");
		if (ExcelPath != null)
			return ExcelPath;
		else
			throw new RuntimeException("Excel data path missing");

	}
}
