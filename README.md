# bootcamp-demo-springboot
- Depdency: Lombok, Spring Web, DevTools
- COntroller:
  - Class level Annotation: @Controller + @ResponseBody, @RequestMapping
  - Method level Annotation: @GetMapping -> URI Path
- API return different types: primitives, wrapper class, String, custom objects
- application.yml -> server.port
- JSON <-> CLass interchange design

### Summary
- Global Exception Handler (@RestControllerAdvice)
  - @ExceptionHandler + @ResponseStatus
- Data Transfer Object (DTO)
    - Objectives: serve API Consumers (DTO = self-defined type)
    - Data object for Receiving API Response (DTO = controlled by API provider)
- Mapper
  - Self-defined mapper (GovMapper.class)
  - Model Mapper (dependencies)
- Library (Infa)
  - ApiResponse.class
  - Syscode.class
  - BcUtil.class (utility - static method)
  - BusinessException (Exception Framework - RuntimeException & CheckException)
- RestTemplate (call external restful API)
  - UriComponentBuilder (host(), path(), toUriString())
- @Value
  - Read yml config