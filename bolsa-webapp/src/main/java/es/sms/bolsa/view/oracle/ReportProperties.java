package es.sms.bolsa.view.oracle;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="steria.reports")
public class ReportProperties {
	
	private String server;
	private String userId;
	private String webCGI;
	private String webServer;
	private String directorio;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWebCGI() {
		return webCGI;
	}
	public void setWebCGI(String webCGI) {
		this.webCGI = webCGI;
	}
	public String getWebServer() {
		return webServer;
	}
	public void setWebServer(String webServer) {
		this.webServer = webServer;
	}
	public String getDirectorio() {
		return directorio;
	}
	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (server != null)
			builder.append("server", server);
		if (userId != null)
			builder.append("userId", userId);
		if (webCGI != null)
			builder.append("webCGI", webCGI);
		if (webServer != null)
			builder.append("webServer", webServer);
		if (directorio != null)
			builder.append("directorio", directorio);
		return builder.toString();
	}
	
}
