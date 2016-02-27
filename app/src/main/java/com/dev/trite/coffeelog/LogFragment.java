package com.dev.trite.coffeelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogFragment extends Fragment
            implements View.OnClickListener{



    public static int[] coffeeCount= { 0, 0, 0, 0, 0, 0, 0 };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private OnFragmentInteractionListener mListener;

    public LogFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sectionNumber Parameter 1.
     * @return A new instance of fragment LogFragment.
     */

    public static LogFragment newInstance(int sectionNumber) {
        LogFragment fragment = new LogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        //get current day of the week
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == dayOfWeek) {
            dayOfWeek = 0;
        } else if (Calendar.TUESDAY == dayOfWeek) {
            dayOfWeek = 1;
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            dayOfWeek = 2;
        } else if (Calendar.THURSDAY == dayOfWeek) {
            dayOfWeek = 3;
        } else if (Calendar.FRIDAY == dayOfWeek) {
            dayOfWeek = 4;
        } else if (Calendar.SATURDAY == dayOfWeek) {
            dayOfWeek = 5;
        } else if (Calendar.SUNDAY == dayOfWeek) {
            dayOfWeek = 6;
        }

        //initiate textView
        final TextView coffeeCounterElement =(TextView) view.findViewById(R.id.coffeeCounter);
        coffeeCounterElement.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        coffeeCounterElement.setText(String.valueOf(LogFragment.coffeeCount[dayOfWeek]));





        //create button and update coffeecount and textview on Click
        ImageButton coffeeCup = (ImageButton) view.findViewById(R.id.coffeeCup);
        coffeeCup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

                if (Calendar.MONDAY == dayOfWeek) {
                    dayOfWeek = 0;
                    LogFragment.coffeeCount[0]++;
                } else if (Calendar.TUESDAY == dayOfWeek) {
                    dayOfWeek = 1;
                    LogFragment.coffeeCount[1]++;
                } else if (Calendar.WEDNESDAY == dayOfWeek) {
                    dayOfWeek = 2;
                    LogFragment.coffeeCount[2]++;
                } else if (Calendar.THURSDAY == dayOfWeek) {
                    dayOfWeek = 3;
                    LogFragment.coffeeCount[3]++;
                } else if (Calendar.FRIDAY == dayOfWeek) {
                    dayOfWeek = 4;
                    LogFragment.coffeeCount[4]++;
                } else if (Calendar.SATURDAY == dayOfWeek) {
                    dayOfWeek = 5;
                    LogFragment.coffeeCount[5]++;
                } else if (Calendar.SUNDAY == dayOfWeek) {
                    dayOfWeek = 6;
                    LogFragment.coffeeCount[6]++;
                }
                System.out.println(dayOfWeek);
                System.out.println(LogFragment.coffeeCount[dayOfWeek]);
                coffeeCounterElement.setText(String.valueOf(LogFragment.coffeeCount[dayOfWeek]));
            }
        });

        return view;
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed( ) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v){

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLogFragmentInteraction(int position);
    }
}
