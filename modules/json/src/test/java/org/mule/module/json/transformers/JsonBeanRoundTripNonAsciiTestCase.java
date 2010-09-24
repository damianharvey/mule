package org.mule.module.json.transformers;

import org.mule.api.endpoint.EndpointBuilder;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.transformer.Transformer;
import org.mule.config.i18n.LocaleMessageHandler;
import org.mule.endpoint.EndpointURIEndpointBuilder;
import org.mule.tck.testmodels.fruit.Apple;
import org.mule.tck.testmodels.fruit.Orange;
import org.mule.transformer.types.SimpleDataType;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class JsonBeanRoundTripNonAsciiTestCase extends JsonBeanRoundTripTestCase
{
    private static final String ENCODING = "Windows-31J";
	
    private final String jsonString;
    private final FruitCollection jsonObject;

    public JsonBeanRoundTripNonAsciiTestCase()
    {
    	jsonString = "{\"apple\":{\"washed\":false,\"bitten\":true},\"orange\":{\"brand\":\""
            +  getBrandOfOrange(Locale.JAPAN)
            + "\",\"segments\":8,\"radius\":3.45,\"listProperties\":null,\"mapProperties\":null,\"arrayProperties\":null}}";
    	
        jsonObject = new FruitCollection(new Apple(true), null, new Orange(8, new Double(3.45), getBrandOfOrange(Locale.JAPAN)));
    }
   
    @Override
    public Transformer getRoundTripTransformer() throws Exception
    {
        Transformer trans = super.getRoundTripTransformer();
        EndpointBuilder builder = new EndpointURIEndpointBuilder("test://test", muleContext);
        builder.setEncoding(ENCODING);
        ImmutableEndpoint endpoint = muleContext.getRegistry().lookupEndpointFactory().getInboundEndpoint(
            builder);
        trans.setEndpoint(endpoint);
        return trans;
    }

    @Override
    public Transformer getTransformer() throws Exception
    {
        Transformer trans = super.getTransformer();
        trans.setReturnDataType(new SimpleDataType<byte[]>(byte[].class));
        EndpointBuilder builder = new EndpointURIEndpointBuilder("test://test", muleContext);
        builder.setEncoding(ENCODING);
        ImmutableEndpoint endpoint = muleContext.getRegistry().lookupEndpointFactory().getInboundEndpoint(
            builder);
        trans.setEndpoint(endpoint);
        return trans;
    }
    
    @Override
    public Object getTestData()
    {
        return jsonObject;
    }

    @Override
    public Object getResultData()
    {
        try
        {
            return jsonString.getBytes(ENCODING);
        }
        catch (UnsupportedEncodingException e)
        {
            fail();
            return null;
        }
    }
	
    private String getBrandOfOrange(Locale locale)
    {
        return LocaleMessageHandler.getString("test-data", locale, "JsonBeanRoundTripNonAsciiTestCase.getBrandOfOrange", new Object[] {});
    }
}
