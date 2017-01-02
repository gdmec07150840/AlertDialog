package cn.edu.gdmec.s07150840.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView = (TextView) this.findViewById(R.id.textView);
        Button button1 = (Button) this.findViewById(R.id.button1);
        Button button2 = (Button) this.findViewById(R.id.button2);
        Button button3 = (Button) this.findViewById(R.id.button3);
        Button button4 = (Button) this.findViewById(R.id.button4);
        Button button5 = (Button) this.findViewById(R.id.button5);
        Button button6 = (Button) this.findViewById(R.id.button6);
        Button button7 = (Button) this.findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }
    //两个按钮，实现是否退出功能；
    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");//弹窗标题
        dialog.setMessage("确认退出吗？");//弹窗提示内容
        dialog.setIcon(android.R.drawable.ic_dialog_alert);//弹窗的小图标

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {//which是点击按钮的ID
                if (which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();//退出弹窗
                    MainActivity.this.finish();//退出当前activity
                }else if (which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    public void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("问话");
        dialog.setMessage("你上面有人吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "我右边有人";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "我中间有人";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "我左边有人";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"人右",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"人中",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"人左",listener);
        dialog.show();
    }

    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你的愿望是什么？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit= new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE){
                    tView.setText("你的愿望是："+tEdit.getText().toString()+",你告诉我又有什么用呢？");
                }else if (which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定许愿",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"老子不许",listener);
        dialog.show();
    }

    public void dialog4(){
        final String item[] = new String[] {"爱德华的觉醒","沉睡的雄师","一个人的世界"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlistener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,new boolean[]{false,true,false},mlistener);//
        bSelect[1] = true;
        dialog =  builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for (int i=0; i < bSelect.length; i++){
                    if (bSelect[i]){
                        str = str + "\n" +item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog5(){
        final String item[] = new String[] {"爱德华的觉醒","沉睡的雄师","一个人的世界","看着我"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i=0; i < bSelect.length; i++){
                    bSelect[i] = false;
                }
                bSelect[which] = true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListener);//
        dialog = builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for (int i=0; i < bSelect.length; i++){
                    if (bSelect[i]){
                        str = str + "\n" +item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    public void dialog6(){
        final String item[] = new String[]{"阶级天极","呵呵有什么的","实力界定一切"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：" + item[which];
                tView.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,sListener);//
        dialog = builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();

    }

    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout1,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.editText);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是：" + tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
}
