package com.sonda.cisco.controller;

import com.sonda.cisco.exceptions.DaoException;
import com.sonda.cisco.model.Clima;
import com.sonda.cisco.model.xml.PhoneImage;
import com.sonda.cisco.model.xml.PhoneImageFile;
import com.sonda.cisco.service.ClimaService;
import com.sonda.cisco.util.ImageClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JanCarlo on 13/05/2016.
 */

@Controller
@RequestMapping("/xml")
public class PhoneImageController {

    @Autowired
    private ClimaService climaService;

    @RequestMapping(value = "/imagendata/{img}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneImage getImagenPhone(HttpServletRequest request, HttpServletResponse response, @PathVariable String img) throws DaoException{

        ImageClima imageClima = new ImageClima();
        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        Clima clima =new Clima();
        clima=climaService.getClima(Long.parseLong("1"));
       // response.addHeader("Refresh", "5; url=http://127.0.0.1:8080/service/xml/imagen/" + img);
        PhoneImage phoneImage = new PhoneImage();
        phoneImage.setTitle("Clima");
        phoneImage.setLocationX(-1);
        phoneImage.setLocationY(-1);
        phoneImage.setHeight(248);
        phoneImage.setWidth(498);
        phoneImage.setDepth(2);
        //phoneImage.setWindowMode("sss");
        phoneImage.setData(imageClima.getDataImage(289,498,"chancetstorms","20","Parcialmente nublado","Ciudad"));
        //phoneImage.setData("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF0F00000000000000000000000000000000000000000000000000000000000000003C0001000000000000000000000000000000000000000000000000000000000000F0F0FFFFFFFFFFFFFFFFFFFFFF0B00000000000000000000000000000000000000C0C3EEFFFFFFFFFFFFFEEFFFFF2F00000000506501100000000000000000000000000FFBFFFFFFFFFFFFFFABFFFF7F00000000905619400000000000000000000000003CFCFBFFFFFFFFFFFF2FF8FBFF010000009001A001000000000000000000000000F0F0FBFFFFFFFFFFBF6FD0FFFF0700000080020001000000000000000000000000C0C3FFFFFFFFFFFFFF7F00BEFF1F0000004006000014406901505A009409000000000FFFFFFFFFFFFFFFBF00E4BB7F000000000900009040560A805606A8A4010000003CFCFFFFFFFFFFFFBF0180FFFF0100000024000040020A60800228640009000000F0F0FFFFFFFFFFFFFF0200F8FF0700000090000000096800000640A00064000000C0C3FFFFFFFFFFFFFF0200D0FF2F0000004002000024906A000900800180020000000FFFFFFFFFFFFFFF070000FE7F000000001900009000501A2400000600060000003CFCFFFFFFFFFFFF0A0000E0FF01000000A00040410200A0800100280018000000F0F0FFFFFFFFFFFF0B000040FF0700000040064006091840020AA0900168000000C0C3FFFFFFFFFFFE1F000000F41F00000000A8510A24A0410A6490011A64000000000FFFFFFFFFFFFF2F00000090BF0000000040AA05900069054096019059000000003CFCFFFFFFFFFF2F00000000FD0200000000000000000000000000000000000000F0F0FFFFFFFFFF7F00000000E00700000000000000000000000000000000000000C0C3FFFFFFFFFFBF00000000001E00000000000000000000000000000000000000000FFFFFFFFFFFBF0100500000B4000000406A406A00A0961600A89106A9AA0500003CFCFFFFFFFFBF0100D007008002000000AA02A802900A6A00A4822AA4AAAA0000F0F0FFFFFFFFFF0200D02F000009000000AA1AA00A401AA402A00A69905AA50A00C0C3FFFFFFFFFF020090FF020000000000A8AA406A006A901A801AA4411A402A00000FFFFFFFFFEF070080FF1F0000000000A4A602A802A900AA402A90066900A802003CFCFFFFFFFF0B0080FFBF0100000000A0861A900AA801A4026A401AA401900A00F0F0FFFFBFFF1B0080FFFF1B00000000900AA9006AA002801AA800699006402A00C0C3FFFFFFFE1F0040FFFEBF01000000802AA402A49106006AA402A4411A00A900000FFFFFFFFF2F0040FEEFFF0B00000000AA951A808A1A00A4A20690066900A802003CFCFBFFFF6F0040FEFBFEBF00000000A9AAAA006A2A00809A0A401AA401A00600F0F0EAFFFF7F0000FEBFFBFF0B000000A855A506A4AA0000A91A00699006A40A00C0C36FBEFBBF0000FEFFFFFF6F000000A002802A80AA0000A02A00A481AAA91A00000FBFE6FFBF0100F9FFFFFFFF060000900A00A900AA020080AA009006A9AA1600003CFC5BFDFF0100F9FFFFFFFF2F0000401500500154010000550140155455010000F0F0FF95FF0200FDFFFFFFFFFB0200000000000000000000000000000000000000C0C3FF1FE50700F9FFFFFFBFFF1F00000000000000000000000000000000000000000FFFFF460A00F8BFFFFFFFBF7F00000000000000000000000000000000000000003CFCFF7F0000F8FFFEFFFFFFFF0100000000000000000000000000000000000000F0F0FFEF0B00F8FFEFFFFFFFFF0B0000800200C000030000000000000028000000C0C3FFFF2F00E4FFFFFFFFFFFF1F0000001A100413844201811140010124105000000FFFFF2F0040A9FFFFFFFFFF7F00000099B0989C32891A6687146E2690659202003CFCFF7F001400A5AAFFFFAF6A00000058832031C8149648085318964062580100F0F0FF7F00A0160054A5AA5605000000645982C420535821615C61580188610500C0C3FFBF00E0BF0600000000000000005050041542085145495145400510581400000FFFFF01A0FBAF16000000000000000000000000000000000000000000000000003CFCFF02D0FFFFAF5A150050A50100501000040000000205400000000000001000F0F0FF0290EFFFFFFFAAAAAAFE0B00408200100000001849400200000000009000C0C3FF0790FFFFFFFFFFFFFFFF1F00004862425454015058514A09664009669402000FFF0B80FFFFFFFFFFFFFFFFBF000060952422910D00228524674902654C2209003CFC0B80FFFFFFFFFFFFFFFFFF0100404A91C88015006814925814099831882400F0F01E40FFFFFFFFFFFFFFFFFF0B000028A821269918D0509862861960C624A600C0C32F40FFFFFFFFFFFFFFFFFF1F00000000000040200000000000000000011000000F3F40FEFFFFFFFFFFFFFFFFBF00000000000000000000000000000000000000003C7C40FEFFFFFFFFFFFFFFFFFF0200000900000000000004008001AB0040000000F0B000FEFBFFFFFFFFFFFFFFFF07000024151814545051605450060C4645420100C08301FEFBFFFFFFFFFFFFFFFF1F00009058629861C656C6619209302426492A00000F01FEFFFFFFFFFFFFFFFFFF7F000040228C7055184319938961C09098209500003C00FDBEFBFFFFFFFFFFFFFFFF01000089308655620C664C269500976182940200F000F9FFFFFFFFFFFFFFFFFFFF0700001041141498115450545001544105450500C003F9FFFFFFFFFFFFFFFFFFFF2F00000000000060020000000000000000000000000FF8AEEAAAAAAAAAAAAAAAAA7E00000000000000010000000000000000000000003C0000000000000000000000000000000000000000000000000000000000000000F00000000000000000000000000000000000000000000000000000000000000000C0FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF03");
        return phoneImage;

    }



    @RequestMapping(value="/imagendata", method=RequestMethod.GET)
    @ResponseBody
    public PhoneImage getImagenPhone() {

        return null;
    }


    @RequestMapping(value = "/imagendata/{ciudad}/{img}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneImage getClimaImagenPhone(@PathVariable String img, @PathVariable String ciudad, HttpServletRequest request, HttpServletResponse response) throws DaoException{

        ImageClima imageClima = new ImageClima();
        System.out.println(request.getHeader("x-ciscoipphonemodelname"));
        System.out.println(request.getHeader("x-ciscoipphonedisplay"));
        Clima clima =new Clima();
        clima=climaService.getClima(Long.parseLong(ciudad));
        // response.addHeader("Refresh", "5; url=http://127.0.0.1:8080/service/xml/imagen/" + img);
        PhoneImage phoneImage = new PhoneImage();
        phoneImage.setTitle("Clima");
        phoneImage.setLocationX(-1);



        phoneImage.setHeight(200);
        phoneImage.setWidth(200);
        phoneImage.setDepth(2);
        phoneImage.setData(imageClima.getDataImage(200,200,clima.getIcon(),clima.getTemperatura(),clima.getDescripcion(),"Ciudad de Mexico"));
        //phoneImage.setData("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF0F00000000000000000000000000000000000000000000000000000000000000003C0001000000000000000000000000000000000000000000000000000000000000F0F0FFFFFFFFFFFFFFFFFFFFFF0B00000000000000000000000000000000000000C0C3EEFFFFFFFFFFFFFEEFFFFF2F00000000506501100000000000000000000000000FFBFFFFFFFFFFFFFFABFFFF7F00000000905619400000000000000000000000003CFCFBFFFFFFFFFFFF2FF8FBFF010000009001A001000000000000000000000000F0F0FBFFFFFFFFFFBF6FD0FFFF0700000080020001000000000000000000000000C0C3FFFFFFFFFFFFFF7F00BEFF1F0000004006000014406901505A009409000000000FFFFFFFFFFFFFFFBF00E4BB7F000000000900009040560A805606A8A4010000003CFCFFFFFFFFFFFFBF0180FFFF0100000024000040020A60800228640009000000F0F0FFFFFFFFFFFFFF0200F8FF0700000090000000096800000640A00064000000C0C3FFFFFFFFFFFFFF0200D0FF2F0000004002000024906A000900800180020000000FFFFFFFFFFFFFFF070000FE7F000000001900009000501A2400000600060000003CFCFFFFFFFFFFFF0A0000E0FF01000000A00040410200A0800100280018000000F0F0FFFFFFFFFFFF0B000040FF0700000040064006091840020AA0900168000000C0C3FFFFFFFFFFFE1F000000F41F00000000A8510A24A0410A6490011A64000000000FFFFFFFFFFFFF2F00000090BF0000000040AA05900069054096019059000000003CFCFFFFFFFFFF2F00000000FD0200000000000000000000000000000000000000F0F0FFFFFFFFFF7F00000000E00700000000000000000000000000000000000000C0C3FFFFFFFFFFBF00000000001E00000000000000000000000000000000000000000FFFFFFFFFFFBF0100500000B4000000406A406A00A0961600A89106A9AA0500003CFCFFFFFFFFBF0100D007008002000000AA02A802900A6A00A4822AA4AAAA0000F0F0FFFFFFFFFF0200D02F000009000000AA1AA00A401AA402A00A69905AA50A00C0C3FFFFFFFFFF020090FF020000000000A8AA406A006A901A801AA4411A402A00000FFFFFFFFFEF070080FF1F0000000000A4A602A802A900AA402A90066900A802003CFCFFFFFFFF0B0080FFBF0100000000A0861A900AA801A4026A401AA401900A00F0F0FFFFBFFF1B0080FFFF1B00000000900AA9006AA002801AA800699006402A00C0C3FFFFFFFE1F0040FFFEBF01000000802AA402A49106006AA402A4411A00A900000FFFFFFFFF2F0040FEEFFF0B00000000AA951A808A1A00A4A20690066900A802003CFCFBFFFF6F0040FEFBFEBF00000000A9AAAA006A2A00809A0A401AA401A00600F0F0EAFFFF7F0000FEBFFBFF0B000000A855A506A4AA0000A91A00699006A40A00C0C36FBEFBBF0000FEFFFFFF6F000000A002802A80AA0000A02A00A481AAA91A00000FBFE6FFBF0100F9FFFFFFFF060000900A00A900AA020080AA009006A9AA1600003CFC5BFDFF0100F9FFFFFFFF2F0000401500500154010000550140155455010000F0F0FF95FF0200FDFFFFFFFFFB0200000000000000000000000000000000000000C0C3FF1FE50700F9FFFFFFBFFF1F00000000000000000000000000000000000000000FFFFF460A00F8BFFFFFFFBF7F00000000000000000000000000000000000000003CFCFF7F0000F8FFFEFFFFFFFF0100000000000000000000000000000000000000F0F0FFEF0B00F8FFEFFFFFFFFF0B0000800200C000030000000000000028000000C0C3FFFF2F00E4FFFFFFFFFFFF1F0000001A100413844201811140010124105000000FFFFF2F0040A9FFFFFFFFFF7F00000099B0989C32891A6687146E2690659202003CFCFF7F001400A5AAFFFFAF6A00000058832031C8149648085318964062580100F0F0FF7F00A0160054A5AA5605000000645982C420535821615C61580188610500C0C3FFBF00E0BF0600000000000000005050041542085145495145400510581400000FFFFF01A0FBAF16000000000000000000000000000000000000000000000000003CFCFF02D0FFFFAF5A150050A50100501000040000000205400000000000001000F0F0FF0290EFFFFFFFAAAAAAFE0B00408200100000001849400200000000009000C0C3FF0790FFFFFFFFFFFFFFFF1F00004862425454015058514A09664009669402000FFF0B80FFFFFFFFFFFFFFFFBF000060952422910D00228524674902654C2209003CFC0B80FFFFFFFFFFFFFFFFFF0100404A91C88015006814925814099831882400F0F01E40FFFFFFFFFFFFFFFFFF0B000028A821269918D0509862861960C624A600C0C32F40FFFFFFFFFFFFFFFFFF1F00000000000040200000000000000000011000000F3F40FEFFFFFFFFFFFFFFFFBF00000000000000000000000000000000000000003C7C40FEFFFFFFFFFFFFFFFFFF0200000900000000000004008001AB0040000000F0B000FEFBFFFFFFFFFFFFFFFF07000024151814545051605450060C4645420100C08301FEFBFFFFFFFFFFFFFFFF1F00009058629861C656C6619209302426492A00000F01FEFFFFFFFFFFFFFFFFFF7F000040228C7055184319938961C09098209500003C00FDBEFBFFFFFFFFFFFFFFFF01000089308655620C664C269500976182940200F000F9FFFFFFFFFFFFFFFFFFFF0700001041141498115450545001544105450500C003F9FFFFFFFFFFFFFFFFFFFF2F00000000000060020000000000000000000000000FF8AEEAAAAAAAAAAAAAAAAA7E00000000000000010000000000000000000000003C0000000000000000000000000000000000000000000000000000000000000000F00000000000000000000000000000000000000000000000000000000000000000C0FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF03");
        return phoneImage;

    }


}
