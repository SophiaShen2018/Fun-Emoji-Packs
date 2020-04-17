package com.example.funemojipacks.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.funemojipacks.HomeFragment;
import com.example.funemojipacks.MainActivity;
import com.example.funemojipacks.R;
import com.example.funemojipacks.RegisterActivity;

public class LoginFragment extends Fragment {

    private View view;
    private Context mContext;
    private TextView mLogin, mLogout;
    private EditText vUsername, vPwd;
    private Fragment userInfoFragment, loginFragment;
    // private Fragment meFragment;

    /*
    public LoginFragment(){
        System.out.println("Login Fragment");
    }

     */

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.me_login, container, false);

        // -- get views
        vUsername = (EditText) view.findViewById(R.id.login_user_name_edit);
        vPwd = (EditText) view.findViewById(R.id.login_pwd_edit);
        mLogin = (TextView) view.findViewById(R.id.login_view);
        mLogout = (TextView) view.findViewById(R.id.me_register_view);

        // -- Listener
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = vUsername.getText().toString();
                String pwd = vPwd.getText().toString();

                if (username.equals("") || pwd.equals("")){
                    Toast.makeText(getContext(), R.string.log_empty_tips, Toast.LENGTH_LONG).show();
                }
                // add more if conditions here
                else{
                    /*
                    Intent intent = new Intent(getActivity(), ShowUserInfoActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    intent.putExtras(bundle);

                    // startActivity(intent);
                    // 带请求码值1到ShowUserInfoActivity
                    startActivityForResult(intent, 1);

                     */

                    // System.out.println("Button Click");
                    Toast.makeText(getContext(), R.string.login_succ_tips, Toast.LENGTH_LONG).show();
                    MainActivity.isLogin = true;

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    if (loginFragment != null) {
                        transaction.hide(loginFragment);
                    }

                    if (userInfoFragment != null) {
                        transaction.hide(userInfoFragment);
                    }

                    if (userInfoFragment == null) {
                        userInfoFragment = new UserInfoFragment();
                        transaction.add(R.id.me_login_layout, userInfoFragment);
                    } else {
                        transaction.show(userInfoFragment);
                    }
                    transaction.commit();

                    // System.out.println("Fragment changed");
                }
            }
        });


        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                // Bundle bundle = new Bundle();
                // intent.putExtras(bundle); startActivity(intent);

                System.out.println("Register a new username");

                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
