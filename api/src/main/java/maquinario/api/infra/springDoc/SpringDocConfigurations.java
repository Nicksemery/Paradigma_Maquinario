package maquinario.api.infra.springDoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. Informações básicas da API (Metadata) - Segurança removida
                .info(new Info()
                        .title("API CIS - Clínica Integrada de Saúde")
                        .description("API REST para gestão de usuários (Psicólogo, Paciente, Coordenação) e agendamento de sessões.")
                        .contact(new Contact()
                                .name("Time Backend CIS")
                                .email("backend@cis.com.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://cis/api/licenca"))
                        .version("1.0.0")
                );
    }
}