package com.example.spsapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.spsapp2.databinding.FragmentSecondBinding;

import com.example.spsapp2.databinding.FragmentFirstBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private FragmentFirstBinding binding1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        //@SergSkol {
        String  strValue = ((MainActivity) getActivity()).getEditText();

        Integer value = 0;
        if(strValue != "" && strValue != null){
            try {
                value = Integer.parseInt(strValue);
            }
            catch(Exception e) {value = 0;}
        } else value = 0;

        Integer ownValue = (int)(Math.random() * 9);

        String isWin = "";
        if(value==ownValue){
            isWin="You are WINNER! ";
        } else isWin="Try again... ";
        binding.textviewSecond.setText(isWin+"Your number is "+value+", my number is "+ownValue);

        //@SergSkol }

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}