<!-- Arquivo que converte o vendas.xml em HTML -->

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- Template da tag venda -->
	<xsl:template match="venda">
	   <h2>Venda</h2>
	   <p>Forma de Pagamento: <xsl:value-of select="formaDePagamento" /></p>
       <!-- Chama o template da tag produtos -->
	   <xsl:apply-templates select="produtos "/>
	</xsl:template>
	
	<!-- Template da tag produtos -->
	<xsl:template match="produtos">
	     <!-- Chama o template da tag produto -->
	    <xsl:apply-templates select="produto" />
	</xsl:template>
	
	<!-- Template da tag produto -->
	<xsl:template match="produto">
	    <h3><xsl:value-of select="nome" /></h3>
	    <p><xsl:value-of select="preco" /></p> 
	</xsl:template>
</xsl:stylesheet>