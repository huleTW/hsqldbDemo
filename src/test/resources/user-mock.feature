Feature: payment service mock

Background:
* def user = {id:'id', firstName:'hu', lastName:'le', career:'Engineer'}

Scenario: pathMatches('/') && methodIs('get')
    * def response = user