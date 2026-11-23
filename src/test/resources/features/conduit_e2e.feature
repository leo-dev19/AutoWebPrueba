@Conduit
Feature: Flujos principales web Conduit

  @RegistrarUsuario
  Scenario Outline: Registrar un nuevo usuario de manera exitosa
    Given el usuario esta en la pagina de inicio de Conduit
    When se registra con usuario "<username>", correo "<email>" y contrasenia "<password>"
    Then deberia ver su nombre de usuario "<username>" en la barra de navegacion

    Examples:
      | username   | email                | password     |
      | leoqaps2027  | leoqaps20271@mail.com   | Contrasenape |

  @CrearArticulo
  Scenario Outline: Iniciar sesion y publicar un nuevo articulo
    Given el usuario esta en la pagina de inicio de Conduit
    And inicia sesion con correo "<email>" y contrasenia "<password>"
    When crea un articulo con titulo "<titulo>", descripcion "<descripcion>", contenido "<contenido>" y tag "<tag>"
    Then deberia visualizar el articulo publicado con el titulo "<titulo>"

    Examples:
      | email              | password     | titulo                    | descripcion            | contenido                        | tag        |
      | leoqaps20271@mail.com | Contrasenape | Pruebita nttdata :)   | llenando la descripcion de algo :vvv | Contenido nuevo pes| automation |

  @ComentarArticulo
  Scenario Outline: Iniciar sesion y comentar el primer articulo del feed
    Given el usuario esta en la pagina de inicio de Conduit
    And inicia sesion con correo "<email>" y contrasenia "<password>"
    When publica el comentario "<comentario>" en el primer articulo disponible
    Then deberia visualizar el comentario "<comentario>" en el articulo

    Examples:
      | email              | password     | comentario                       |
      | leoqaps20271@mail.com | Contrasenape | Buen feed felicitaciones contratado :v |