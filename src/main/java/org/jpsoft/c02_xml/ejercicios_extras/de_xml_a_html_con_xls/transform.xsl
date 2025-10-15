<?xml version="1.0" encoding="utf-8" ?>
<stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <title>productos</title>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
                      crossorigin="anonymous"/>
            </head>

            <body>
                <div class="container">
                    <div class="row text-center">
                        <xsl:for-each select="productos/producto">
                            <div class="col-4">
                                <div class="card" style="width: 18rem;">
                                    <div class="card-body">
                                        <h5 class="card-title">
                                            <xsl:value-of select="nombre"/>
                                        </h5>
                                        <h6 class="card-subtitle mb-2 text-body-secondary">Precio:
                                            <xsl:value-of select="precio"/>
                                        </h6>
                                    </div>
                                </div>
                            </div>
                        </xsl:for-each>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>


</stylesheet>