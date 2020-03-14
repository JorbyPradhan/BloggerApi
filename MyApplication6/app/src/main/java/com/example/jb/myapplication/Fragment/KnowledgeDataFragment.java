package com.example.jb.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jb.myapplication.Adapter;
import com.example.jb.myapplication.DataBaseHandler;
import com.example.jb.myapplication.R;
import com.example.jb.myapplication.model.User;


public class KnowledgeDataFragment extends Fragment {
    View v;
DataBaseHandler db;
    /*private List<User> mData;*/
    static User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_knowledge_data, container, false);
        ImageView img=(ImageView)v.findViewById(R.id.img);
        Integer[]Book={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.k};
        String[] Description={"This new edition of Volume 1 covers the latest IPng development and information. The text discusses security in TCP/IP environments and firewall designs as well as bridges and routers, presenting routing architectures for large and small internets. It also explains TCP transport services.","This complete guide to setting up and running a TCP/IP network is essential for network administrators, and invaluable for users of home systems that access the Internet. The book starts with the fundamentals -- what protocols do and how they work, how addresses and routing are used to move data through the network, how to set up your network connection -- and then covers, in detail, everything you need to know to exchange information via the Internet.Included are discussions on advanced routing protocols (RIPv2, OSPF, and BGP) and the gated software package that implements them, a tutorial on configuring important network services -- including DNS, Apache, sendmail, Samba, PPP, and DHCP -- as well as expanded chapters on troubleshooting and security. TCP/IP Network Administration is also a command and syntax reference for important packages such as gated, pppd, named, dhcpd, and sendmail.With coverage that includes Linux, Solaris, BSD, and System V TCP/IP implementations...","Computer Networking continues with an early emphasis on application-layer paradigms and application programming interfaces (the top layer), encouraging a hands-on experience with protocols and networking concepts, before working down the protocol stack to more abstract layers.\n" +
                "\n" +
                "This book has become the dominant book for this course because of the authors’ reputations, the precision of explanation, the quality of the art program, and the value of their own supplements." +
                "Visit the authors’ blog for information and resources to discuss the newest edition, as well as valuable insights, teaching tips, and discussion about the field of Computer Networking .","\"Data Communications and Networking 3/e\" provides a comprehensive and current introduction to networking technologies. The book is accessible to students from all backgrounds and uses hundreds of figures to visually represent concepts. This new edition has been completely updated to reflect the constantly changing world of network technologies, such as bluetooth, wireless and updated security coverage. Optional algorithm sections have been added, which allow instructors to adjust the level of math that they would like to use in the course. The TCP/IP coverage has also been expanded and moved earlier in the new edition. Forouzan's book continues to be supported by an On-line Learning Centre (OLC) that contains many extra resources for students and instructors. Some of the features include PowerPoints, solutions, self-quizzing, and Flash animations that illustrate concepts.","Computer Network တစ္ခု ခ်ိတ္ဆက္ရာတြင္ သိရွိထားရမည့္ အခ်က္မ်ား၊ အသုံးျပဳသည့္ Hardware ပစၥည္းမ်ား၊ IP အေၾကာင္း၊ ကြန္ပ်ဴတာဖုိင္မ်ားႏွင့္ ပစၥည္းမ်ားကို Networkမွတဆင့္ Share လုပ္သုံးစြဲပုံ၊ Server တစ္လုံးထုိင္ပုံမ်ားကို လက္ေတြ႕လုပ္ေဆာင္ပုံမ်ားႏွင့္တကြ ရွင္းလင္းေရးသားထားေသာ စာအုပ္ျဖစ္သည္။",
                "Hilton Cattႏွင့္ Patricia Scudamore တုိ႔ေရးသားသည့္ “... to Improve Your Networking Skills”စာအုပ္ကို ဘာသာျပန္ဆုိထားျခင္း ျဖစ္သည္။ ကြန္ယက္ဖြဲ႕စည္းရန္အတြက္ လူေရြးခ်ယ္ပုံ၊ အေျခခံအေဆာက္အအုံမ်ား ထားရွိပုံ၊ ကြန္ယက္ကို ထိထိေရာက္ေရာက္ အလုပ္လုပ္ေစပုံ၊ ကြန္ယက္ဖြဲ႕ အလုပ္လုပ္မႈစြမ္းရည္မ်ားကို အသုံးခ်ပုံႏွင့္ ကြန္ယက္ဆုိင္ရာ ေဆာင္ရန္, ေရွာင္ရန္မ်ားကို ဤစာအုပ္တြင္ အပိုင္း (၆) ပုိင္းခြဲ၍ ဖတ္႐ႈေလ့လာၾကရမည္ ျဖစ္သည္။",
        ": Networking ဆုိင္ရာ သီအုိရီမ်ားကို ေက်ေက်ညက္ညက္ ေလ့လာလုိသူမ်ားအတြက္ ဤစာအုပ္တြင္ ကြန္ယက္နည္းပညာမ်ဳိးစုံ၏ သီအုိရီမ်ားကို အေသးစိတ္ ႐ွင္းလင္းေရးသားထားသည္။ အထူးသျဖင့္ CCNAစာေမးပြဲ ၀င္ေရာက္ေျဖဆုိမည့္သူမ်ားကို ဤစာအုပ္က အေထာက္အကူျပဳမည္ျဖစ္သည္။ ၄င္းစာေမးပြဲအတြက္ Configurationဆိုင္ရာ ပညာရပ္မ်ားကို စာေရးသူသည္ ယခင္က “Road To CCNA”စာအုပ္တြင္ အေသးစိတ္ရွင္းျပခဲ့ၿပီးျဖစ္သည္။ ယခုစာအုပ္မွာမူ သီအုိရီပိုင္းကို အဓိကထား ရွင္းလင္းထားျခင္းျဖစ္သည္။ စာေမးပြဲေျဖဆုိမည့္သူမ်ားအေနျဖင့္ ၄င္း ၂ အုပ္ကို လက္စြဲထား ေလ့လာသင့္သည္ဟု စာေရးသူက အၾကံေပးထားသည္။",
        "Cisco Certified Internet Expert (CCIE) လက္မွတ္ရရွိထားသူ စာေရးသူက သူ၏ စာေတြ႕ လက္ေတြ႕အေတြ႕အၾကံဳမ်ားကို ျပန္လည္မွ်ေ၀ထားျခင္း ျဖစ္သည္။ CCIE ၏ သမုိင္းေၾကာင္း၊ CCIE စာေမးပြဲေျဖဆုိမည့္သူမ်ား ေလ့လာထားရမည့္ နည္းပညာရပ္မ်ား၊ လက္ေတြ႕စမ္းသပ္ပုံမ်ားကို သ႐ုပ္ေဖာ္ပုံမ်ားႏွင့္တကြ ရွင္းလင္း ေရးသားထားသည္။",
        "Network ေလာကတြင္ အသုံးအမ်ားဆုံး၊ ေလ့လာရအလြယ္ကူဆုံးျဖစ္သည့္ Cisco Networkအေၾကာင္းကို Study Guide ပုံစံထက္ စာေရးသူကုိယ္တုိင္ ေလ့လာခဲ့သည္မ်ား၊ လုပ္ငန္းခြင္အေတြ႕အၾကံဳမ်ား၊ Theoryပုိင္းဆုိင္ရာမ်ား၊ Configure ျပဳလုပ္ပုံမ်ားကို Diagramမ်ားႏွင့္တကြ ျပည့္ျပည့္စုံစုံ ရွင္းလင္းေရးသားထားေသာ စာအုပ္ျဖစ္သည္။ Networking အေျခခံ၊ OSI Model အေၾကာင္း၊ IP Protocolအေၾကာင္း၊ Transport Layer : TCPႏွင့္ UDPအေၾကာင္း၊ Ethernet အေၾကာင္း၊ Cisco IOSအေၾကာင္း၊ Virtual Lan (VLAN), Trunkႏွင့္ VTPအေၾကာင္း၊ Spanning Tree (STP)အေၾကာင္း၊ Etherchannel (Link Aggregation)အေၾကာင္း၊ Subnetting အေၾကာင္း၊ Routing Between VLAN ၊ FHRP (First Hop Redundancy Protocol) အေၾကာင္း၊ IP Routing အေၾကာင္း၊ EIGRP အေၾကာင္း၊ OSPF အေၾကာင္း၊ Access Control Lists (ACLs)အေၾကာင္း၊ Networking Address Translation (NAT)အေၾကာင္း၊ IOS Licensing အေၾကာင္း၊ VPN အေၾကာင္း၊ IPv6 Introductionအေၾကာင္းတုိ႔ကို အေသးစိတ္ ေရးသားရွင္းလင္းထားသည္။",
        "ကြန္ပ်ဴတာတစ္လုံးတည္းကို Station စက္မ်ားပြား၍ သုံးႏုိင္သည့္ နည္းပညာအေၾကာင္းကို ရွင္းလင္းထားေသာ စာအုပ္ျဖစ္သည္။ ကြန္ပ်ဴတာသင္တန္းမ်ား၊ အင္တာနက္ဆုိင္မ်ား၊ စာသင္ေက်ာင္းမ်ား၊ ႐ုံးမ်ား၊ ကုမၸဏီမ်ား ကုန္က်စရိတ္နည္းနည္းႏွင့္ အလုပ္တြင္က်ယ္ေစမည့္ နည္းပညာျဖစ္သည္။ Net Station, Thin Clientစက္မ်ား ခ်ိတ္ဆက္ပုံ၊ Software ထည့္သြင္းပုံ၊ Setting ခ်ိန္ညႇိပုံ၊ Networking သေဘာတရားမ်ားကို လက္ေတြ႕လုပ္ေဆာင္ပုံမ်ားႏွင့္တကြ ေရးသားရွင္းလင္းထားသည္။"};
        String[]Link={"https://www.amazon.com/Internetworking-TCP-Vol-Principles-Architecture/dp/0132169878","https://www.amazon.com/TCP-Network-Administration-OReilly-Networking/dp/0596002971","https://www.amazon.com/Computer-Networking-Top-Down-Approach-6th/dp/0132856204","https://www.amazon.com/Data-Communications-Networking-Behrouz-Forouzan/dp/0071232419","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/42065","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/31142","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/18205","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/43159","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/35295","http://www.myanmarbookshop.com/MyanmarBooks/BookDetails/35183"};
        ListView lst=(ListView)v.findViewById(R.id.listView);
        Adapter adapter= new Adapter(getActivity(),Book,Description,Link);
        lst.setAdapter(adapter);
        /*TextView des=(TextView)v.findViewById(R.id.name2);
        db=new DataBaseHandler(getActivity());

            user = db.getData(2);
            img.setImageResource(user.getPhoto());*/

        return v;
    }


    public KnowledgeDataFragment(){}
}
