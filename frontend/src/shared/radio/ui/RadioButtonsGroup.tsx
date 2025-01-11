import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import { useState, useEffect, ChangeEvent } from "react";
import { SelectEntity } from "../../entities/select/Select";

type Props = {
  title: string;
  items: Array<SelectEntity>;
  handleChange: (value: SelectEntity) => void;
  initialValue?: SelectEntity;
};

function RadioButtonsGroup({
  title,
  items=[],
  handleChange,
  initialValue,
}: Props) {
  const [state, setState] = useState(initialValue ? initialValue : items[0]);

  const clickHandler = (event:ChangeEvent<HTMLInputElement>) => {
    const val = items.find(item=>item.id == event.target.value)
    if(val){
        setState(val);
    }
  };

  useEffect(() => {
        handleChange(state);
  }, [state]);

  return (
    <FormControl>
      <FormLabel id="demo-radio-buttons-group-label">{title}</FormLabel>
      <RadioGroup
        aria-labelledby="demo-radio-buttons-group-label"
        defaultValue={state}
        name="radio-buttons-group"
        onChange={clickHandler}
      >
        {items.map((item) => (
          <FormControlLabel
            key={item.id}
            value={item.id}
            control={<Radio />}
            label={item.name}
          />
        ))}
      </RadioGroup>
    </FormControl>
  );
}

export default RadioButtonsGroup;
