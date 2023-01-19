# this is meant to be sourced into your .bashrc
if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; then
  echo "ERROR: This script is not meant to be run on its own,"
  echo "but sourced into your bashrc with a line like"
  echo "  source $0"
  exit 1
fi

function 211sync {
  (
    cd $HOME/ic211
    git add .
    if git diff-index --quiet --cached HEAD -- || git diff-files --quiet; then
      echo "Committing current changes"
      msg="working on $(basename "$(pwd)")"
      echo git commit -a -m "msg"
      git commit -a -m "msg"
      echo
    fi
    echo
    echo "Getting updates from your repo"
    echo git pull 
    git pull
    echo
    echo "Copying your work to your repo"
    echo git push
    git push
  )
}
