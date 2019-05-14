package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/greeting'
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body("Hello Consumer")
        headers {
            contentType('application/json')
        }
    }
}
