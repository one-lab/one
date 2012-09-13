<?xml version="1.0" encoding="UTF-8"?>
<application>
	<display-name>${seam_appname}</display-name>

	<module>
		<web>
			<web-uri>${seam_shortname}.war</web-uri>
			<context-root>/${seam_shortname}</context-root>
		</web>
	</module>
	<module>
		<ejb>${seam_shortname}.ejb3</ejb>
	</module>
	
</application>