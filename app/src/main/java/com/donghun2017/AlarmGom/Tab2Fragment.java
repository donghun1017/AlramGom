package com.donghun2017.AlarmGom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Tab2Fragment extends Fragment {

    ListView listView;
    ListViewAdapter2 adapter2;

    ArrayList<ListViewItem2> members = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        members.add(new ListViewItem2("늦은 저녁", R.drawable.sound1));
        members.add(new ListViewItem2("숲속에 앉아서", R.drawable.sound2));
        members.add(new ListViewItem2("밤하늘 바라보며", R.drawable.sound3));
        members.add(new ListViewItem2("잔잔한 하루의 끝", R.drawable.sound4));
        members.add(new ListViewItem2("어느 처마 밑", R.drawable.sound5));
        members.add(new ListViewItem2("하루의 장마", R.drawable.sound6));
        members.add(new ListViewItem2("궂은 어느 날", R.drawable.sound7));
        members.add(new ListViewItem2("회상에 잠기며", R.drawable.sound8));
        members.add(new ListViewItem2("떠밀려오는 기억", R.drawable.sound9));
        members.add(new ListViewItem2("해질무렵의 고백", R.drawable.sound10));
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);


        listView = (ListView)view.findViewById(R.id.listView2);
        adapter2 = new ListViewAdapter2(members, inflater);


        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {
                    Intent intent = new Intent(getContext(), Sound1Activity.class);
                    startActivity(intent);
                }else if(position==1){
                    Intent intent = new Intent(getContext(), Sound2Activity.class);
                    startActivity(intent);
                }else if(position==2){
                    Intent intent = new Intent(getContext(), Sound3Activity.class);
                    startActivity(intent);
                }else if(position==3){
                    Intent intent = new Intent(getContext(), Sound4Activity.class);
                    startActivity(intent);
                }else if(position==4){
                    Intent intent = new Intent(getContext(), Sound5Activity.class);
                    startActivity(intent);
                }else if(position==5){
                    Intent intent = new Intent(getContext(), Sound6Activity.class);
                    startActivity(intent);
                }else if(position==6){
                    Intent intent = new Intent(getContext(), Sound7Activity.class);
                    startActivity(intent);
                }else if(position==7){
                    Intent intent = new Intent(getContext(), Sound8Activity.class);
                    startActivity(intent);
                }else if(position==8){
                    Intent intent = new Intent(getContext(), Sound9Activity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getContext(), Sound10Activity.class);
                    startActivity(intent);
                }


            }
        });


        return view;
    }

}


