package com.example.akhilraj.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.akhilraj.herome.Activities.MainActivity;
import com.example.akhilraj.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button accidentButton;
    private Button genericButton;
    private Button bornButton;
    private Button chooseButton;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentButton = (Button) view.findViewById(R.id.accidentButton);
        genericButton = (Button) view.findViewById(R.id.genericButton);
        bornButton = (Button) view.findViewById(R.id.bornButton);
        chooseButton = (Button) view.findViewById(R.id.chooseButton);

        accidentButton.setOnClickListener(this);
        genericButton.setOnClickListener(this);
        bornButton.setOnClickListener(this);
        chooseButton.setOnClickListener(this);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });

        chooseButton.setEnabled(false);
        chooseButton.getBackground().setAlpha(128);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        chooseButton.setEnabled(true);
        chooseButton.getBackground().setAlpha(255);
        Button button = (Button) v;
        int leftDrawable = 0;
        int rightDrawable = R.drawable.item_selected;

        if (button == accidentButton) {
            leftDrawable = R.drawable.lightning;
        } else if (button == genericButton) {
            leftDrawable = R.drawable.atomic;
        } else if (button == bornButton) {
            leftDrawable = R.drawable.rocket;
        } else if (button == chooseButton) {
            rightDrawable = 0;
        }

        accidentButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, 0, 0);
        genericButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic, 0, 0, 0);
        bornButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket, 0, 0, 0);

        button.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, rightDrawable, 0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
