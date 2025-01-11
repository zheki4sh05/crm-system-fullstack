import { Box, Container, Stack } from "@mui/material";
import { useState } from "react";
import { Source } from "../../../../shared/entities/deal/source/Source";
import { Group } from "../../../../shared/entities/group/Group";
import { Stage } from "../../../../shared/entities/stage/Stage";
import { MoreAboutDeal } from "../../../../shared/entities/deal/Deal";
import RadioButtonsGroup from "../../../../shared/radio/ui/RadioButtonsGroup";
import { SelectEntity } from "../../../../shared/entities/select/Select";
import MainBtn from "../../../../shared/button/ui/MainBtn";

type Props = {
  handleSubmit: (value: MoreAboutDeal) => void;
  stages: Array<Stage>;
  groups: Array<Group>;
  value: MoreAboutDeal;
};

function AddMoreAboutDeal({ handleSubmit, stages, groups, value }: Props) {
  // const sources = useSelector(getSources)

  // const dealTypes = useSelector(getDealTypes)

  const [change, setChange] = useState(false);
  const [source, setSource] = useState(value.source);
  const [group, setGroup] = useState(value.group);
  const [stage, setStage] = useState(value.stage);

  const changeSourceHandler = (value: Source) => {
    setChange(true);
    setSource(value);
  };

  const changeStageHandler = (value: SelectEntity) => {
    const stage = stages.find(item=>item.id == value.id)
    if(stage){
      setChange(true);
      setStage(stage);
    }
  };
  const handleChangeGroup = (value: SelectEntity) => {
    const group = groups.find(item=>item.id == value.id)
    if(group){
      setChange(true);
      setGroup(group);
    }
  };

  const handleFormSubmit = () => {
    if(stage){
      handleSubmit({source, group, stage});
      setChange(false);
    }
  };

  const getStagesByGroup = (value:Group) => {
    return stages.filter((item) => item.groupId == value.id);
  };

  return (
    <Box sx={{ mt: 5 }}>
      <Container maxWidth="sm">
        <Stack direction="column" spacing={2}>
          <RadioButtonsGroup
            title={"Источник"}
            items={[]}
            handleChange={changeSourceHandler}
            initialValue={source}
          />


          {groups.length != 0 && stages.length != 0 ? (
            <>
              <RadioButtonsGroup
                title={"Группа"}
                items={groups}
                handleChange={handleChangeGroup}
                initialValue={group}
              />

              {group ? (
                <RadioButtonsGroup
                  title={"Стадия"}
                  items={getStagesByGroup(group)}
                  handleChange={changeStageHandler}
                  initialValue={stage}
                />
              ) : null}
            </>
          ) : null}

          <Box
            sx={{
              display: "flex",
              justifyContent: "flex-end",
            }}
          >
            <MainBtn
              btnClickHandler={handleFormSubmit}
              text={"Сохранить"}
              disable={!change}
            />
          </Box>
        </Stack>
      </Container>
    </Box>
  );
}

export default AddMoreAboutDeal;
