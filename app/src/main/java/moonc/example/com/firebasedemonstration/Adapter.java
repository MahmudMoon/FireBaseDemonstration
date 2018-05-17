package moonc.example.com.firebasedemonstration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Context mContext;
    LayoutInflater layoutInflater;
    ArrayList<Employee> mArrayList;
    TextView name,email,phone_num;


    public Adapter(Context mContext, ArrayList<Employee> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = layoutInflater.inflate(R.layout.adapter,null);
        name = (TextView)view.findViewById(R.id.tv_name);
        email = (TextView)view.findViewById(R.id.tv_email);
        phone_num = (TextView)view.findViewById(R.id.tv_phone);

        name.setText(mArrayList.get(position).getUser_name());
        email.setText(mArrayList.get(position).getUser_email());
        phone_num.setText(mArrayList.get(position).getUser_phone());

        return view;
    }
}
