using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace SQEditor.GameObjects
{
    public abstract class Serializable
    {
        public abstract string GetType();
        public abstract XElement ToXML();
        public abstract void Save();
    }
}
