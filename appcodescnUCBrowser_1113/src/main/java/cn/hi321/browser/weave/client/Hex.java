/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Hex
{
    private static final HexEncoder encoder = new HexEncoder();

    /**
     * encode the input data producing a Hex encoded byte array.
     *
     * @return a byte array containing the Hex encoded data.
     */
    public static byte[] encode(
        byte[]    data)
    {
        return encode(data, 0, data.length);
    }

    /**
     * encode the input data producing a Hex encoded byte array.
     *
     * @return a byte array containing the Hex encoded data.
     */
    public static byte[] encode(
        byte[]    data,
        int       off,
        int       length)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();

        try
        {
            encoder.encode(data, off, length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception encoding Hex string: " + e);
        }

        return bOut.toByteArray();
    }

    /**
     * Hex encode the byte data writing it to the given output stream.
     *
     * @return the number of bytes produced.
     */
    public static int encode(
        byte[]         data,
        OutputStream   out)
        throws IOException
    {
        return encoder.encode(data, 0, data.length, out);
    }

    /**
     * Hex encode the byte data writing it to the given output stream.
     *
     * @return the number of bytes produced.
     */
    public static int encode(
        byte[]         data,
        int            off,
        int            length,
        OutputStream   out)
        throws IOException
    {
        return encoder.encode(data, off, length, out);
    }

    /**
     * decode the Hex encoded input data. It is assumed the input data is valid.
     *
     * @return a byte array representing the decoded data.
     */
    public static byte[] decode(
        byte[]    data)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();

        try
        {
            encoder.decode(data, 0, data.length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding Hex string: " + e);
        }

        return bOut.toByteArray();
    }

    /**
     * decode the Hex encoded String data - whitespace will be ignored.
     *
     * @return a byte array representing the decoded data.
     */
    public static byte[] decode(
        String    data)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();

        try
        {
            encoder.decode(data, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding Hex string: " + e);
        }

        return bOut.toByteArray();
    }

    /**
     * decode the Hex encoded String data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    public static int decode(
        String          data,
        OutputStream    out)
        throws IOException
    {
        return encoder.decode(data, out);
    }
}