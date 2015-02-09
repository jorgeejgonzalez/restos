Feature: La aplicacion debe autenticar al usuario a traves de su email y un password

Scenario: Realizar Login

	Given que el Usuario acceptance@test.com este registrado en la base de datos
	And su password es acceptance 
	When se invoque el servicio de Autenticacion
	Then el HTTP Response Status debe ser 200 